package entities

import Scenes.SpaceScene
import com.soywiz.korev.Key
import com.soywiz.korge.internal.KorgeInternal
import com.soywiz.korge.view.Circle
import com.soywiz.korge.view.addUpdater
import com.soywiz.korim.color.Colors

@KorgeInternal
class Player(val spaceScene: SpaceScene) : Circle(100.0, Colors.RED, Colors.BLACK, 10.0) {

    init {
        addUpdater {
            val input = stage?.input
            if (input != null) {
                if (input.keys.pressing(Key.A)) {
                    x -= 5
                }
                if (input.keys.pressing(Key.D)) {
                    x += 5
                }
                if (input.keys.pressing(Key.W)) {
                    y -= 5
                }
                if (input.keys.pressing(Key.S)) {
                    y += 5
                }
            }
        }
//
        //                for (child in parent?.children!!) {
//                    println(child)
//                    if (collidesWithShape(child)) {
//                        solid.x = 300.0
//                        solid.y = 1000.0
////                        x = 0.0
////                        y = 0.0
//                    }
//                }
//
//                if (x < 0) {
//                    x = 0.0
//                }
//                if (y < 22) {
//                    y = 22.0
//                }
//
//                if (x + width >= 1280) {
//                    x = 1280 - width
//                }
//
//                if (y + height >= 768) {
//                    y = 768 - height
//                }
//}
//}
//}
    }
}
