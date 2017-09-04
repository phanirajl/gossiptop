package com.rustyrazorblade.gossiptop

import io.grpc.Server
import io.grpc.ServerBuilder


fun main(args: Array<String>) {
    println("Running the server!")

    var db = TraceDB("/tmp/testdb")
    var server = ServerBuilder.forPort(5000).addService(GossipListenerService(db)).build()
    server.awaitTermination()

}


