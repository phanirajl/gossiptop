import com.rustyrazorblade.gossiptop.NotFoundException
import org.junit.Test
import org.junit.Assert.*

import com.rustyrazorblade.gossiptop.TraceDB;
import org.junit.Before
import org.neo4j.graphdb.factory.GraphDatabaseFactory
import org.neo4j.test.TestGraphDatabaseFactory
import java.io.File

class TraceDBTests {
    private lateinit var db: TraceDB

    @Before
    fun createDatabase() {
        var neodb = TestGraphDatabaseFactory().newImpermanentDatabase();
        db = TraceDB(neodb)
    }

    @Test
    fun testCreateNode() {
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

    @Test
    fun testGetNode() {
        db.createNode("127.0.0.1")
        var node = db.getNode("127.0.0.1")
        assertEquals("127.0.0.1", node.ip)
    }

    @Test(expected = NotFoundException::class)
    fun testGetNodeNotFound() {
        var node2 = db.getNode("127.0.0.1")
    }

    @Test
    fun testListNodes() {
        db.createNode("127.0.0.1")
        db.createNode("127.0.0.2")
        db.createNode("127.0.0.3")

        var nodes = db.listAllNodes()
        assertEquals(3, nodes.count())

    }
}