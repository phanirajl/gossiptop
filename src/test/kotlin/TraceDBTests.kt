import org.junit.Test

import com.rustyrazorblade.gossiptop.TraceDB;

class TraceDBTests {
    @Test
    fun testCreateNode() {
        var db = TraceDB("/tmp/db/whatever")
        db.createNode("127.0.0.1")
    }
}