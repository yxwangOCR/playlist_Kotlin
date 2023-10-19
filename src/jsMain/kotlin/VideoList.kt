
import csstype.Cursor
import emotion.react.css
import react.*
import react.dom.html.ReactHTML.p

external interface VideoListProps : Props {
    var videos: List<Video>
    var selectedVideo: Video?
    var onSelectVideo: (Video) -> Unit
}

val VideoList = FC<VideoListProps> {props ->

    for (video in props.videos) {
        p {
            css {
                cursor = Cursor.pointer
            }
            key = video.id.toString()
            onClick = {
                props.onSelectVideo(video)
            }
            if (video == props.selectedVideo) {
                +"\uD83D\uDC49 "
            }
            +"${video.speaker}: ${video.title}"
        }
    }
}

