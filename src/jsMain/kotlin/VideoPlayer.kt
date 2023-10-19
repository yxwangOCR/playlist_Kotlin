import csstype.*
import react.*
import emotion.react.css
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.img

external interface VideoPlayerProps : Props {
    var video: Video
    var onWatchedButtonPressed: (Video) -> Unit
    var unwatchedVideo: Boolean
}

val VideoPlayer = FC<VideoPlayerProps> { props ->
    div {
        css {
            position = Position.absolute
            top = 10.px
            right = 10.px
        }
        h3 {
            +"${props.video.speaker}: ${props.video.title}"
        }
        button {
            css {
                display = Display.block
                backgroundColor = if (props.unwatchedVideo) NamedColor.lightgreen else NamedColor.red
                border = 0.px
                borderRadius = 10.px
                padding = 15.px
                marginBottom = 10.px
                cursor = Cursor.pointer

            }
            onClick = {
                props.onWatchedButtonPressed(props.video)
            }
            if (props.unwatchedVideo) {
                +"Mark as watched"
            } else {
                +"Mark as unwatched"
            }
        }

        ReactPlayer {
            url = props.video.videoUrl
            controls = true
        }
        div {
            css {
                position = Position.relative
                top = 20.px
            }
            EmailShareButton {
                url = props.video.videoUrl
                EmailIcon {
                    size = 32
                    round = true
                }
            }
            LinkedinShareButton {
                url = props.video.videoUrl
                LinkedinIcon {
                    size = 32
                    round = true
                }
            }
            FacebookShareButton {
                url = props.video.videoUrl
                FacebookIcon {
                    size = 32
                    round = true
                }
            }
        }

    }
}