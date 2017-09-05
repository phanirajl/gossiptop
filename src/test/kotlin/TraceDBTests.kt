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
        var node = nodes[0]
        assertEquals("127.0.0.1", node.ip)

        db.createNode("127.0.0.2")
        var nodes2 = db.listAllNodes()
        var count2 = nodes2.count()
        assertEquals(2, count2)

    }

    @Test
    fun testListAll() {

    }
}