import com.soywiz.korge.view.Views
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

class Resources {
    lateinit var playerIdle: Bitmap
    lateinit var playerRunning: Bitmap

    suspend fun load() {
        playerIdle = resourcesVfs["Idle.png"].readBitmap()
        playerRunning = resourcesVfs["Run.png"].readBitmap()
    }
}

class Game {
    lateinit var views: Views
    var stageWidth = 3325
    var stageHeight = 1970
    var currentLeveLIndex = 0

    //    var levels = listOf(
//        level(name="", into="", ktree="", background="", Point(x,y))
//    )
    val resources = Resources()
}
