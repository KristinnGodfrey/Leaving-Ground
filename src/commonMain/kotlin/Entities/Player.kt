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
        playAnimationLooped(game.resources.playerRunningAnimation)
    }

    private fun moveDownLeft() {
        y += 5
        x -= 5
        playAnimationLooped(game.resources.playerRunningAnimation)
    }

    private fun idle() {
        playAnimation(game.resources.playerIdleAnimation)
    }

    private fun jump() {
        y -= 10
        playAnimationLooped(game.resources.playerJumpingAnimation)
    }

    private fun moveDown() {
        y += 5
        playAnimationLooped(game.resources.playerRunningAnimation)
    }

    private fun moveUp() {
        y -= 5
        playAnimationLooped(game.resources.playerRunningAnimation)
    }

    private fun moveLeft() {
        x -= 5
        playAnimationLooped(game.resources.playerRunningAnimation)
    }

    private fun moveRight() {
        x += 5
        playAnimationLooped(game.resources.playerRunningAnimation)
    }

    private fun jumpRightUp() {
        y -= 10
        x += 10
        playAnimationLooped(game.resources.playerJumpingAnimation)
    }

    private fun jumpLeftUp() {
        y -= 10
        x -= 10
        playAnimationLooped(game.resources.playerJumpingAnimation)
    }


}
