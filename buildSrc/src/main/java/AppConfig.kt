import java.io.File
import java.util.Properties

object AppConfig {
    const val applicationId = "com.molidev8.template"
    const val compileSdk = 33
    const val minSdk = 26
    const val targetSdk = 33
    const val buildToolsVersion = "30.0.3"
    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val proguardRules = "proguard-rules.pro"

    fun readVersionName(projectDir: String? = null): String {
        with(getVersionProperties(projectDir)) {
            val versionMajor = getProperty("versionMajor")
            val versionMinor = getProperty("versionMinor")
            val versionPatch = getProperty("versionPatch")
            return "$versionMajor.$versionMinor.$versionPatch"
        }
    }

    fun readVersionCode(projectDir: String? = null): Int {
        with(getVersionProperties(projectDir)) {
            val versionCode = getProperty("versionCode")
            return versionCode.toInt()
        }
    }

    private fun getVersionProperties(projectDir: String?): Properties {
        val versionProperties = Properties()
        println("${projectDir}/config/version/version.properties")

        val versionFile = if (projectDir != null) {
            File("${projectDir}/config/version/version.properties")
        } else File("config/version/version.properties")
        versionProperties.load(versionFile.reader())
        return versionProperties
    }
}
