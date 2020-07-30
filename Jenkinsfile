library 'atlas-pipeline-scripts'

def Map templateParams = [:]
templateParams["TEAM"] = "atlas"
templateParams["APP"] = "service/event-aggregation-service"

templateParams["ENABLE_SCA"] = true
templateParams["ENABLE_FORTIFY"] = true
templateParams["ENABLE_DEP_CHECK"] = true
templateParams["ENABLE_SONARQUBE"] = true
templateParams["ENABLE_IMAGE_VERSIONING"] = true
templateParams["ENABLE_PUBLISH_ARTIFACTS"] = true
templateParams["ENABLE_TAF_TEST"] = true
templateParams["ENABLE_DEPLOY_TEST_INTEGRATION"] = true
templateParams["ENABLE_RELEASE_PHASE"] = true

def Map images = [:]
images["baseImage"] = "${templateParams.TEAM}/${templateParams.APP}"
//images["dataStoreImage"] = ""
//images["tafImage"] = "${templateParams.TEAM}/${templateParams.APP}-taf"

templateParams["BUILD_IMAGE"] = images
String upstreamProjects = "SSAC2/atlas-parent/develop"

template(templateParams, upstreamProjects)
