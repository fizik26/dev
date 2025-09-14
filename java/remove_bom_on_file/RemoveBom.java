import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class RemoveBom {

    public InputStream removeBomMethod(MultipartFile file) throws IOException {
        if (isContainBOM(file)) {

            byte[] bytes = file.getBytes();

            ByteBuffer bb = ByteBuffer.wrap(bytes);

            byte[] bom = new byte[3];

            // get the first 3 bytes
            bb.get(bom, 0, bom.length);

            // remaining
            byte[] contentAfterFirst3Bytes = new byte[bytes.length - 3];
            bb.get(contentAfterFirst3Bytes, 0, contentAfterFirst3Bytes.length);

            // override the same path
            return new ByteArrayInputStream(contentAfterFirst3Bytes);
        }

        return file.getInputStream();
    }

    private static boolean isContainBOM(MultipartFile file) throws IOException {
        byte[] bom = new byte[3];

        try (InputStream is = file.getInputStream()) {

            // read 3 first bytes of a file
            int charRead = is.read(bom);

            // BOM encoded as ef bb bf
            if (charRead > 0) {
                String content = new String(Hex.encodeHex(bom));
                if ("efbbbf".equalsIgnoreCase(content)) {
                    return true;
                }
            }
        }
        return false;
    }
}
