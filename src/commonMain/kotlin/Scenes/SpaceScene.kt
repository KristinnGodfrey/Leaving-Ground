package Scenes

import com.soywiz.korge.internal.KorgeInternal
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korim.format.readBitmap
import com.soywiz.korio.file.std.resourcesVfs
import entities.Player

class SpaceSceneDependency(val value: String)

class SpaceScene(val spaceSceneDependency: SpaceSceneDependency) : Scene() {
    @KorgeInternal
    val player = Player(this)

    @KorgeInternal
    override suspend fun Container.sceneInit() {
        sprite(resourcesVfs["skywide.png"].readBitmap()) {}
        val rect1 = solidRect(100, 100, Colors.BLUE).xy(200, 300)
        val rect2 = solidRect(100, 100, Colors.BLUE).xy(350, 300)
        val rectList = listOf(rect1, rect2)

        addChild(player)
        addChild(rect1)
        addChild(rect2)


        player.addUpdater {
            if (collidesWith(rectList)) {
                player.xy(0, 0)
            }
        }

    }
}