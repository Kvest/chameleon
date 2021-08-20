import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.p

fun main() {
    window.onload = {
        render(document.getElementById("root")) {
            p { "Chameleon" }
        }
    }
}
