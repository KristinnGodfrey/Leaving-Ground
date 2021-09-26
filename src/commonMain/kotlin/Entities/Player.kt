package entities

import Game
import Scenes.SpaceScene
import com.soywiz.korev.Key
import com.soywiz.korge.internal.KorgeInternal
import com.soywiz.korge.view.*
import com.soywiz.korma.geom.vector.circle

@KorgeInternal
class Player(val spaceScene: SpaceScene, val game: Game) : Sprite() {
    val playerIdle: SpriteAnimation = game.resources.playerIdleAnimation
    val playerRunning: SpriteAnimation = game.resources.playerRunningAnimation
    val playerJumping: SpriteAnimation = game.resources.playerJumpingAnimation

    init {
        name = "player"
        anchor(0.5, 0.5)
        hitShape { circle(100, 100, 10) }
        scale(0.5)
        playAnimationLooped(game.resources.playerIdleAnimation)

        // TODO: rotation = 180.0.degrees not working
        addUpdater {
//            y += 5
            val input = game.views.keys

            val index = when {
                input.justPressed(Key.A) and input.justPressed(Key.SPACE) -> jumpLeftUp()
                input.justPressed(Key.D) and input.justPressed(Key.SPACE) -> jumpRightUp()
                input.justPressed(Key.A) -> moveLeft()
                input.justPressed(Key.D) -> moveRight()
                input.justPressed(Key.W) -> moveUp()
                input.justPressed(Key.S) -> moveDown()
                input.justPressed(Key.SPACE) -> jump()
                else -> idle()
            }


            if (!a or !d or !w or !s or !j) {
                playAnimation(game.resources.playerIdleAnimation)
            }
            if (j) {
                y -= 10
                playAnimationLooped(game.resources.playerJumpingAnimation)
            }
            if (j and a) {
                y -= 10
                x -= 10
            } else if (a) {
                x -= 5
                playAnimationLooped(game.resources.playerRunningAnimation)
            }
            if (j and d) {
                y -= 10
                x += 10
            } else if (d) {
                x += 5
                playAnimationLooped(game.resources.playerRunningAnimation)
            }
            if (w) {
                y -= 5
                playAnimationLooped(game.resources.playerRunningAnimation)
            }
            if (s) {
                y += 5
                playAnimationLooped(game.resources.playerRunningAnimation)
            }

        }
    }

    private fun jump(): Any {

    }

    private fun moveDown(): Any {

    }

    private fun moveUp(): Any {

    }

    private fun moveRight(): Any {

    }

    private fun jumpRightUp(): Any {

    }

    private fun jumpLeftUp(): Any {

    }

    private fun moveLeft(): Any {

    }
}
