package Scenes

import Game
import com.soywiz.klock.timesPerSecond
import com.soywiz.korge.internal.KorgeInternal
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import entities.Cloud
import entities.Player

class SpaceSceneDependency(val value: String)

class SpaceScene(val spaceSceneDependency: SpaceSceneDependency, val game: Game) : Scene() {
    @KorgeInternal
    val player = Player(this, game).xy(1000, 400)

//    @KorgeInternal
//    val cloud = Cloud(this, game)

    @KorgeInternal
    override suspend fun Container.sceneInit() {
//        val bg = sprite(resourcesVfs["skywide.png"].readBitmap()) {}
        val bg = game.resources.bgImage
        val rect1 = solidRect(100, 100, Colors.BLUE).xy(200, 300)
        val rect2 = solidRect(100, 100, Colors.BLUE).xy(350, 300)
        val rectList = listOf(rect1, rect2)
        val cloud = Cloud(this@SpaceScene, game)

        addChild(bg)
        addChild(player)
        addChild(rect1)
        addChild(rect2)
        addChild(cloud.cloud1)


        player.addUpdater {
            if (collidesWith(rectList)) {
                player.xy(0, 0)
            }
        }
        bg.addFixedUpdater(100.timesPerSecond) {
            bg.y -= 0.1
        }
    }
}
