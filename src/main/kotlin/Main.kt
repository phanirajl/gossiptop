package com.rustyrazorblade.gossiptop

import io.grpc.Server
import io.grpc.ServerBuilder


fun main(args: Array<String>) {
    println("Running the server!")

    var server = ServerBuilder.forPort(5000).addService(GossipListenerService()).build()
    server.awaitTermination()

}


