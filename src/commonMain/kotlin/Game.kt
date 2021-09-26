import com.soywiz.korge.view.SpriteAnimation
import com.soywiz.korge.view.Views
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

class Resources {
    //    lateinit var playerIdleMap: Bitmap
    lateinit var playerIdleAnimation: SpriteAnimation
    lateinit var playerRunningAnimation: SpriteAnimation
//    lateinit var playerIdle: Sprite
//    lateinit var playerRunningMap: Bitmap

    suspend fun load() {
        val playerIdleMap = resourcesVfs["Idle.png"].readBitmap()
        val playerRunningMap = resourcesVfs["Running.png"].readBitmap()

        playerIdleAnimation = SpriteAnimation(
            spriteMap = playerIdleMap,
            spriteWidth = 1595 / 5,
            spriteHeight = 972 / 2,
            marginTop = 0,
            marginLeft = 0,
            columns = 5,
            rows = 2,
            offsetBetweenColumns = 0,
            offsetBetweenRows = 0,
        )
        playerRunningAnimation = SpriteAnimation(
            spriteMap = playerRunningMap,
            spriteWidth = 2075 / 5,
            spriteHeight = 1014 / 2,
            marginTop = 0,
            marginLeft = 0,
            columns = 5,
            rows = 2,
            offsetBetweenColumns = 0,
            offsetBetweenRows = 0,
        )
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
