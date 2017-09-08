import java.nio.file.Files
import java.nio.file.Path

class FileIO {
    boolean check() {
        Files.delete(new File('/tmp/test').toPath())
        println('xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx')
        return false
    }
}
