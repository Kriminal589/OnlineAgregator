rootProject.name = "OnlineAgregator"
include("Parser")
include("Aggregator")
include("Parser:src:main:test")
findProject(":Parser:src:main:test")?.name = "test"
