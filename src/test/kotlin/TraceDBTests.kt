import org.junit.Test
import org.junit.Assert.*

import com.rustyrazorblade.gossiptop.TraceDB;

class TraceDBTests {
    @Test
    fun testCreateNode() {
        var db = TraceDB("/tmp/db/whatever")
        db.createNode("127.0.0.1")
        var nodes = db.listAllNodes()
        var count = nodes.count()
        assertEquals(1, count)
    }

    @Test
    fun testListAll() {

    }
}