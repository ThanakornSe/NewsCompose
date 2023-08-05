pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NewsCompose"
include(":app")
include(":core:data")
include(":core:network")
include(":core:resource")
include(":core:ui")
include(":core:util")
include(":data:newsdata")
include(":domain:newsfeed")
include(":domain:newsdetail")
include(":feature:newsfeed")
include(":feature:newsdetail")
