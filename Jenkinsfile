library 'atlas-pipeline-scripts'

def Map templateParams = [:]
templateParams["TEAM"] = "atlas"
templateParams["APP"] = "event-aggregation/event-aggregation-service"

templateParams["ENABLE_SCA"] = true
templateParams["ENABLE_FORTIFY"] = false
templateParams["ENABLE_DEP_CHECK"] = true
templateParams["ENABLE_SONARQUBE"] = false
templateParams["ENABLE_IMAGE_VERSIONING"] = true
templateParams["ENABLE_PUBLISH_ARTIFACTS"] = true
templateParams["ENABLE_TAF_TEST"] = false
templateParams["ENABLE_DEPLOY_TEST_INTEGRATION"] = true
templateParams["ENABLE_RELEASE_PHASE"] = true

def Map images = [:]
images["baseImage"] = "${templateParams.TEAM}/${templateParams.APP}"
//images["dataStoreImage"] = ""
//images["tafImage"] = "${templateParams.TEAM}/${templateParams.APP}-taf"

templateParams["BUILD_IMAGE"] = images
String upstreamProjects = "atlas/atlas-parent/master"

template(templateParams, upstreamProjects)
