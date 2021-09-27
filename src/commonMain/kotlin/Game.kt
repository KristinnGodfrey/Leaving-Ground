import com.soywiz.korge.view.Image
import com.soywiz.korge.view.SpriteAnimation
import com.soywiz.korge.view.Views
import com.soywiz.korge.view.position
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs

class Resources {
    //    lateinit var playerIdleMap: Bitmap
    lateinit var bgImage: Image
    lateinit var playerIdleAnimation: SpriteAnimation
    lateinit var playerRunningAnimation: SpriteAnimation
    lateinit var playerJumpingAnimation: SpriteAnimation
    lateinit var cloud1: Image
//    lateinit var cloud2: Sprite
//    lateinit var cloud3: Sprite
//    lateinit var playerIdle: Sprite
//    lateinit var playerRunningMap: Bitmap

    suspend fun load() {
        var bgImageMap = resourcesVfs["sky.png"].readBitmap()
        val playerIdleMap = resourcesVfs["Idle.png"].readBitmap()
        val playerRunningMap = resourcesVfs["Running.png"].readBitmap()
        val playerJumpingMap = resourcesVfs["Jumping.png"].readBitmap()
        val cloud1Map = resourcesVfs["cloud1.png"].readBitmap()
//        val cloud2Map = resourcesVfs["cloud2.PNG"].readBitmap()
//        val cloud3Map = resourcesVfs["cloud3.PNG"].readBitmap()

//        cloud1 = Sprite(cloud1Map, 0.5, 0.5, null, false)
        bgImage = Image(bgImageMap)

        cloud1 = Image(cloud1Map).apply {
            position(1200, 1600)
        }

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
        playerJumpingAnimation = SpriteAnimation(
            spriteMap = playerJumpingMap,
            spriteWidth = 2013 / 5,
            spriteHeight = 1072 / 2,
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
