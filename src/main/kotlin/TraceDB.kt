package com.rustyrazorblade.gossiptop

import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.Label
import org.neo4j.graphdb.Node
import org.neo4j.graphdb.ResourceIterator
import org.neo4j.graphdb.factory.GraphDatabaseFactory
import java.io.File

data class CassandraNode(val ip: String)

class NotFoundException(override var message:String): Exception()

class TraceDB(val db: GraphDatabaseService) {
    private val SERVER: Label = Label.label("server")
    private val MESSAGE: Label = Label.label("message")

    // update the state
    fun createNode(ip: String) {
        val tx = db.beginTx()
        var node = db.createNode(*arrayOf(SERVER))
        node.setProperty("ip", ip)
        tx.success()
    }

    // fetch all the nodes
    fun listAllNodes() : ArrayList<CassandraNode> {
        var nodes = db.findNodes(SERVER)
        var result = arrayListOf<CassandraNode>()
        for (node in nodes) {
            result.add(CassandraNode(node.getProperty("ip") as String))
        }
        return result
    }

    fun getNode(ip: String): CassandraNode {
        var tx = db.beginTx()

        try {
            val node = db.findNode(SERVER, "ip", ip)
            return CassandraNode(node.getProperty("ip") as String)
        } catch (e: Exception) {
            throw NotFoundException(ip + " not found")
        } finally {
            tx.success()
        }
    }

    fun getReceivedMessages(ip: String) {

    }
}