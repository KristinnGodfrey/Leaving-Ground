import com.soywiz.korge.view.Sprite
import com.soywiz.korge.view.SpriteAnimation
import com.soywiz.korge.view.Views
import com.soywiz.korim.bitmap.Bitmap
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

class Resources {
    lateinit var playerIdleMap: Bitmap
    lateinit var playerIdleAnimation: SpriteAnimation
    lateinit var playerIdle: Sprite
    lateinit var playerRunningMap: Bitmap

    suspend fun load() {
        playerIdleMap = resourcesVfs["Idle.png"].readBitmap()

        playerIdleAnimation = SpriteAnimation(
            spriteMap = playerIdleMap,
            spriteWidth = 319,
            spriteHeight = 486,
            marginTop = 0,
            marginLeft = 0,
            columns = 5,
            rows = 2,
            offsetBetweenColumns = 0,
            offsetBetweenRows = 0,
        )
//
//        playerIdle = sprite(playerIdleAnimation)

//        playerRunningMap = resourcesVfs["Run.png"].readBitmap()
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
