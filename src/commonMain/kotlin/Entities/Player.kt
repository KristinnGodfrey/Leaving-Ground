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

        // TODO: rotation = 180.0.degrees
        addUpdater {
            val input = game.views.keys

            when {
                input.pressing(Key.A) and input.pressing(Key.SPACE) -> jumpLeftUp()
                input.pressing(Key.D) and input.pressing(Key.SPACE) -> jumpRightUp()
                input.pressing(Key.A) and input.pressing(Key.S) -> moveDownLeft()
                input.pressing(Key.D) and input.pressing(Key.S) -> moveDownRight()
                input.pressing(Key.A) -> moveLeft()
                input.pressing(Key.D) -> moveRight()
                input.pressing(Key.S) -> moveDown()
                input.pressing(Key.SPACE) -> jump()
                else -> idle()
            }
        }
    }

    private fun moveDownRight() {
        y += 5
        x += 5
        playAnimationLooped(playerRunning)
    }

    private fun moveDownLeft() {
        y += 5
        x -= 5
        playAnimationLooped(playerRunning)
    }

    private fun idle() {
        playAnimation(playerIdle)
    }

    private fun jump() {
        y -= 10
        playAnimationLooped(playerJumping)
    }

    private fun moveDown() {
        y += 5
        playAnimationLooped(playerRunning)
    }

    private fun moveUp() {
        y -= 5
        playAnimationLooped(playerRunning)
    }

    private fun moveUpLeft() {
        x -= 5
        y -= 5
        playAnimationLooped(playerRunning)
    }

    private fun moveUpRight() {
        x += 5
        y -= 5
        playAnimationLooped(playerRunning)
    }

    private fun moveLeft() {
        x -= 5
        playAnimationLooped(playerRunning)
    }

    private fun moveRight() {
        x += 5
        playAnimationLooped(playerRunning)
    }

    private fun jumpRightUp() {
        y -= 10
        x += 10
        playAnimationLooped(playerJumping)
    }

    private fun jumpLeftUp() {
        y -= 10
        x -= 10
        playAnimationLooped(playerJumping)
    }
}
