package yanbal.com.pe.webviewyanbal

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Browser
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {
        btnTabIntent.setOnClickListener {
            val url = etWebUrl.text.toString()
            if (validateUrl(url)) {
                val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJpYXQiOjYzNzk0NDk5NDY1NjEzODUxMCwiR3VpZCI6ImU4ZTcyZTNmLWE5ODQtNDA5Ny1iNTg0LThmNjMwYTk0NTBmYSIsIkxvZ2luSWQiOiJ0aGlsZWVwLnZhbiIsIk9yZ2FuaXNhdGlvbklkIjoyLCJEaXZpc2lvbklkIjozLCJVc2VySWQiOjU4MSwiRGlzdHJpYnV0b3JJZCI6MCwiRGlzdHJpYnV0b3JIaWVyYXJjaHlJZCI6MCwiUmV0YWlsZXJJZCI6MCwiUGFzc3dvcmQiOiIyIn0.bR1dgnd_rjGfMQ1NEDi0Cei2MKNLA7UDXF9iDAS1PGd-Ek3xhHaa1VFfkjsxugqi"
                val bundle = Bundle()
                bundle.putString("SECURITY_TOKEN_KEY", token)

                val builder = CustomTabsIntent.Builder()
                builder.setToolbarColor(
                    ContextCompat.getColor(
                        applicationContext,
                        R.color.colorPrimaryDark
                    )
                )

                val customTabsIntent = builder.build()
                customTabsIntent.intent.putExtra(Browser.EXTRA_HEADERS, bundle)
                customTabsIntent.launchUrl(this, Uri.parse(url))
            }
        }
        /*
        * 1. our xl , 2.sample xl , 3.our pdf
        * */
        btnWebview.setOnClickListener {
            val url = etWebUrl.text.toString()
            if (validateUrl(url)) {
                val base64Str = "CiAgICAgICAgICAgICAgICAgICAgPHRhYmxlIGNsYXNzPSJ0YWJsZS1ib3JkZXJlZCI+CiAgICAgICAgICAgICAgICAgICAgICAgIDx0aGVhZCBpZD0iU2VsbGVyTGlzdGhlYWRlciI+PHRyPjx0aCBjbGFzcz0idGhjbHMiPkRhdGU8L3RoPjx0aCBjbGFzcz0idGhjbHMiPlNlbGxlcjwvdGg+PHRoIGNsYXNzPSJ0aGNscyI+T3JkZXIgQ291bnQ8L3RoPjx0aCBjbGFzcz0idGhjbHMiPk9yZGVyIFZhbHVlczwvdGg+PC90cj48L3RoZWFkPgogICAgICAgICAgICAgICAgICAgICAgICA8dGJvZHkgaWQ9IlNlbGxlckxpc3QiPjx0cj48dGQgY29sc3Bhbj0iMiIgY2xhc3M9InRkY2xzIGZvb3RlciI+R3JhbmQgVG90YWw8L3RkPjx0ZCBjbGFzcz0idGRjbHMgZm9vdGVyIj4wPC90ZD48dGQgY2xhc3M9InRkY2xzIGZvb3RlciI+MDwvdGQ+PC90cj48L3Rib2R5PgogICAgICAgICAgICAgICAgICAgIDwvdGFibGU+CiAgICAgICAgICAgICAgICA="
//                val base64Str = "0M8R4KGxGuEAAAAAAAAAAAAAAAAAAAAAOwADAP7/CQAGAAAAAAAAAAAAAAABAAAADgAAAAAAAAAAEAAACwAAAAEAAAD+////AAAAAAAAAAD////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////9/////////wMAAAAEAAAABQAAAAYAAAAHAAAACAAAAAkAAAAKAAAA/v////7///8NAAAA/v///w8AAAD+/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////1IAbwBvAHQAIABFAG4AdAByAHkAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAWAAUA////////////////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA/v///wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD///////////////8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD+////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP///////////////wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP7///8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA////////////////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA/v///wAAAAAAAAAACQgQAAAGBQC7DcwHAAAAAAYAAADhAAIAsATBAAIAAADiAAAAXABwAAQAAENhbGMgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICBCAAIAsARhAQIAAADAAQAAPQECAAEAnAACAA4ArwECAAAAvAECAAAAPQASAAAAAAAAQAAgOAAAAAAAAQDNAEAAAgAAAI0AAgAAACIAAgAAAA4AAgABALcBAgAAANoAAgAAADEAGgDIAAAA/3+QAQAA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AP0ACgAIAAQAFwAKAAAAfgIKAAgABQAPAG4AAAD9AAoACAAGAA8ADwAAAH4CCgAIAAcADwBiJgAAfgIKAAkAAAAPACYAAAD9AAoACQABAA8AHwAAAP0ACgAJAAIADwAgAAAA/QAKAAkAAwAPAAkAAAD9AAoACQAEABcACgAAAH4CCgAJAAUADwCiAAAA/QAKAAkABgAPABQAAAB+AgoACQAHAA8AUmYAAOwAUAAPAALwSAAAABAACPAIAAAAAQAAAAAEAAAPAAPwMAAAAA8ABPAoAAAAAQAJ8BAAAAAAAAAAAAAAAAAAAAAAAAAAAgAK8AgAAAAABAAABQAAAD4CEgC2BgAAAABAAAAAAAAAAAAAAAAdAA8AAxEACgAAAAEAEQARAAoKZwgXAGcIAAAAAAAAAAAAAAIAAf////8AAAAACgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAAAP7////+////BAAAAAUAAAAGAAAABwAAAP7///8JAAAA/v////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////8BAP7/AwoAAP////8QCAIAAAAAAMAAAAAAAABGGwAAAE1pY3Jvc29mdCBFeGNlbCA5Ny1UYWJlbGxlAAYAAABCaWZmOAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEAAAIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD+/wAAAQACAAAAAAAAAAAAAAAAAAAAAAABAAAA4IWf8vlPaBCrkQgAKyez2TAAAAAIAQAADQAAAAEAAABwAAAAAgAAAHgAAAADAAAAhAAAAAQAAACQAAAABQAAAJwAAAAGAAAAqAAAAAcAAAC0AAAACAAAAMAAAAAJAAAAzAAAAAoAAADYAAAACwAAAOQAAAAMAAAA8AAAAA0AAAD8AAAAAgAAAOn9AAAeAAAAAQAAAAAAAAAeAAAAAQAAAAAAAAAeAAAAAQAAAAAAAAAeAAAAAQAAAAAAAAAeAAAAAQAAAAAAAAAeAAAAAQAAAAAAAAAeAAAAAQAAAAAAAAAeAAAAAgAAADQAAABAAAAAgN8YwsQAAABAAAAAAAAAAAAAAABAAAAALFw68z0M0wFAAAAAY/Ou8gMN0wEAAAAAAAAAAP7/AAABAAIAAAAAAAAAAAAAAAAAAAAAAAIAAAAC1c3VnC4bEJOXCAArLPmuRAAAAAXVzdWcLhsQk5cIACss+a5cAAAAGAAAAAEAAAABAAAAEAAAAAIAAADp/QAAGAAAAAEAAAABAAAAEAAAAAIAAADp/QAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAUgBvAG8AdAAgAEUAbgB0AHIAeQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABYABQD//////////wEAAAAQCAIAAAAAAMAAAAAAAABGAAAAAAAAAAAAAAAAAAAAAAAAAAAMAAAAgAIAAAAAAABXAG8AcgBrAGIAbwBvAGsAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEgACAAIAAAAEAAAA/////wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAIAAABdEAAAAAAAAAEAQwBvAG0AcABPAGIAagAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASAAIAAwAAAP//////////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEkAAAAAAAAAAQBPAGwAZQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAoAAgD///////////////8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACAAAAFAAAAAAAAAAFAFMAdQBtAG0AYQByAHkASQBuAGYAbwByAG0AYQB0AGkAbwBuAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAKAACAP////8FAAAA/////wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMAAAA4AQAAAAAAAAUARABvAGMAdQBtAGUAbgB0AFMAdQBtAG0AYQByAHkASQBuAGYAbwByAG0AYQB0AGkAbwBuAAAAAAAAAAAAAAA4AAIA////////////////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACAAAAHQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD///////////////8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD+////AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP///////////////wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP7///8AAAAAAAAAAA=="
//                val base64Str = "JVBERi0xLjMKMyAwIG9iago8PC9UeXBlIC9QYWdlCi9QYXJlbnQgMSAwIFIKL1Jlc291cmNlcyAyIDAgUgovTWVkaWFCb3ggWzAgMCA1OTUuMjggODQxLjg5XQovQ29udGVudHMgNCAwIFIKPj4KZW5kb2JqCjQgMCBvYmoKPDwvTGVuZ3RoIDIxNjU+PgpzdHJlYW0KMC4yMCB3CjAgRwpCVAovRjEgOSBUZgoxMC4zNSBUTAowIGcKNDAuMDAgNzgxLjg5IFRkCihPcmRlciBTdW1tZXJ5IFJlcG9ydCkgVGoKRVQKMC4xNiAwLjUwIDAuNzMgcmcKMC43OCBHCjAuMTAgdwowLjE2IDAuNTAgMC43MyByZwowLjc4IEcKMC4xMCB3CjAuMTYgMC41MCAwLjczIHJnCjAuNzggRwowLjEwIHcKMC4xNiAwLjUwIDAuNzMgcmcKMC43OCBHCjAuMTAgdwowLjk2IGcKMC43OCBHCjAuMTAgdwowLjk2IGcKMC43OCBHCjAuMTAgdwowLjk2IGcKMC43OCBHCjAuMTAgdwowLjk2IGcKMC43OCBHCjAuMTAgdwoxLjAwIGcKMC43OCBHCjAuMTAgdwoxLjAwIGcKMC43OCBHCjAuMTAgdwoxLjAwIGcKMC43OCBHCjAuMTAgdwoxLjAwIGcKMC43OCBHCjAuMTAgdwowLjk2IGcKMC43OCBHCjAuMTAgdwowLjk2IGcKMC43OCBHCjAuMTAgdwowLjk2IGcKMC43OCBHCjAuMTAgdwowLjk2IGcKMC43OCBHCjAuMTAgdwoxLjAwIGcKMC43OCBHCjAuMTAgdwoxLjAwIGcKMC43OCBHCjAuMTAgdwoxLjAwIGcKMC43OCBHCjAuMTAgdwoxLjAwIGcKMC43OCBHCjAuMTAgdwowLjE2IDAuNTAgMC43MyByZwowLjc4IEcKMC4xMCB3CjAuMTYgMC41MCAwLjczIHJnCjAuNzggRwowLjEwIHcKMC4xNiAwLjUwIDAuNzMgcmcKMC43OCBHCjAuMTAgdwowLjE2IDAuNTAgMC43MyByZwowLjc4IEcKMC4xMCB3CjAuMTYgMC41MCAwLjczIHJnCjAuNzggRwowLjEwIHcKNDAuMDAgNzcxLjg5IDExMy43NyAtMjMuMDAgcmUKZgpCVAovRjIgMTAgVGYKMTEuNSBUTAoxLjAwMCBnCjQ1LjAwIDc1OC4zOSBUZAooRGF0ZSkgVGoKRVQKMC4xNiAwLjUwIDAuNzMgcmcKMC43OCBHCjAuMTAgdwoxNTMuNzcgNzcxLjg5IDExNy45NiAtMjMuMDAgcmUKZgpCVAovRjIgMTAgVGYKMTEuNSBUTAoxLjAwMCBnCjE1OC43NyA3NTguMzkgVGQKKFNlbGxlcikgVGoKRVQKMC4xNiAwLjUwIDAuNzMgcmcKMC43OCBHCjAuMTAgdwoyNzEuNzMgNzcxLjg5IDEzOS4zNSAtMjMuMDAgcmUKZgpCVAovRjIgMTAgVGYKMTEuNSBUTAoxLjAwMCBnCjI3Ni43MyA3NTguMzkgVGQKKE9yZGVyIENvdW50KSBUagpFVAowLjE2IDAuNTAgMC43MyByZwowLjc4IEcKMC4xMCB3CjQxMS4wNyA3NzEuODkgMTQ0LjIxIC0yMy4wMCByZQpmCkJUCi9GMiAxMCBUZgoxMS41IFRMCjEuMDAwIGcKNDE2LjA3IDc1OC4zOSBUZAooT3JkZXIgVmFsdWVzKSBUagpFVAowLjk2IGcKMC43OCBHCjAuMTAgdwo0MC4wMCA3NDguODkgMTEzLjc3IC0yMC4wMCByZQpmCkJUCi9GMSA5IFRmCjEwLjM1IFRMCjAuMzE0IGcKNDUuMDAgNzM2LjI0IFRkCigxNS8wNi8yMDIyKSBUagpFVAowLjk2IGcKMC43OCBHCjAuMTAgdwoxNTMuNzcgNzQ4Ljg5IDExNy45NiAtMjAuMDAgcmUKZgpCVAovRjEgOSBUZgoxMC4zNSBUTAowLjMxNCBnCjE1OC43NyA3MzYuMjQgVGQKKHRoaWxlZXAudmFuICApIFRqCkVUCjAuOTYgZwowLjc4IEcKMC4xMCB3CjI3MS43MyA3NDguODkgMTM5LjM1IC0yMC4wMCByZQpmCkJUCi9GMSA5IFRmCjEwLjM1IFRMCjAuMzE0IGcKMjc2LjczIDczNi4yNCBUZAooOCkgVGoKRVQKMC45NiBnCjAuNzggRwowLjEwIHcKNDExLjA3IDc0OC44OSAxNDQuMjEgLTIwLjAwIHJlCmYKQlQKL0YxIDkgVGYKMTAuMzUgVEwKMC4zMTQgZwo0MTYuMDcgNzM2LjI0IFRkCigxMDM0MC4wMCkgVGoKRVQKMS4wMCBnCjAuNzggRwowLjEwIHcKNDAuMDAgNzI4Ljg5IDExMy43NyAtMjAuMDAgcmUKZgpCVAovRjEgOSBUZgoxMC4zNSBUTAowLjMxNCBnCjQ1LjAwIDcxNi4yNCBUZAooR3JhbmQgVG90YWwpIFRqCkVUCjEuMDAgZwowLjc4IEcKMC4xMCB3CjE1My43NyA3MjguODkgMTE3Ljk2IC0yMC4wMCByZQpmCkJUCi9GMSA5IFRmCjEwLjM1IFRMCjAuMzE0IGcKMTU4Ljc3IDcxNi4yNCBUZAooKSBUagpFVAoxLjAwIGcKMC43OCBHCjAuMTAgdwoyNzEuNzMgNzI4Ljg5IDEzOS4zNSAtMjAuMDAgcmUKZgpCVAovRjEgOSBUZgoxMC4zNSBUTAowLjMxNCBnCjI3Ni43MyA3MTYuMjQgVGQKKDgpIFRqCkVUCjEuMDAgZwowLjc4IEcKMC4xMCB3CjQxMS4wNyA3MjguODkgMTQ0LjIxIC0yMC4wMCByZQpmCkJUCi9GMSA5IFRmCjEwLjM1IFRMCjAuMzE0IGcKNDE2LjA3IDcxNi4yNCBUZAooMTAzNDApIFRqCkVUCkJUCi9GMSA5IFRmCjEwLjM1IFRMCjAuMTE4IGcKMjc3LjY0IDEwLjAwIFRkCihQYWdlIDEgb2YgMSkgVGoKRVQKZW5kc3RyZWFtCmVuZG9iagoxIDAgb2JqCjw8L1R5cGUgL1BhZ2VzCi9LaWRzIFszIDAgUiBdCi9Db3VudCAxCj4+CmVuZG9iago1IDAgb2JqCjw8L0Jhc2VGb250L0hlbHZldGljYS9UeXBlL0ZvbnQKL0VuY29kaW5nL1dpbkFuc2lFbmNvZGluZwovU3VidHlwZS9UeXBlMT4+CmVuZG9iago2IDAgb2JqCjw8L0Jhc2VGb250L0hlbHZldGljYS1Cb2xkL1R5cGUvRm9udAovRW5jb2RpbmcvV2luQW5zaUVuY29kaW5nCi9TdWJ0eXBlL1R5cGUxPj4KZW5kb2JqCjcgMCBvYmoKPDwvQmFzZUZvbnQvSGVsdmV0aWNhLU9ibGlxdWUvVHlwZS9Gb250Ci9FbmNvZGluZy9XaW5BbnNpRW5jb2RpbmcKL1N1YnR5cGUvVHlwZTE+PgplbmRvYmoKOCAwIG9iago8PC9CYXNlRm9udC9IZWx2ZXRpY2EtQm9sZE9ibGlxdWUvVHlwZS9Gb250Ci9FbmNvZGluZy9XaW5BbnNpRW5jb2RpbmcKL1N1YnR5cGUvVHlwZTE+PgplbmRvYmoKOSAwIG9iago8PC9CYXNlRm9udC9Db3VyaWVyL1R5cGUvRm9udAovRW5jb2RpbmcvV2luQW5zaUVuY29kaW5nCi9TdWJ0eXBlL1R5cGUxPj4KZW5kb2JqCjEwIDAgb2JqCjw8L0Jhc2VGb250L0NvdXJpZXItQm9sZC9UeXBlL0ZvbnQKL0VuY29kaW5nL1dpbkFuc2lFbmNvZGluZwovU3VidHlwZS9UeXBlMT4+CmVuZG9iagoxMSAwIG9iago8PC9CYXNlRm9udC9Db3VyaWVyLU9ibGlxdWUvVHlwZS9Gb250Ci9FbmNvZGluZy9XaW5BbnNpRW5jb2RpbmcKL1N1YnR5cGUvVHlwZTE+PgplbmRvYmoKMTIgMCBvYmoKPDwvQmFzZUZvbnQvQ291cmllci1Cb2xkT2JsaXF1ZS9UeXBlL0ZvbnQKL0VuY29kaW5nL1dpbkFuc2lFbmNvZGluZwovU3VidHlwZS9UeXBlMT4+CmVuZG9iagoxMyAwIG9iago8PC9CYXNlRm9udC9UaW1lcy1Sb21hbi9UeXBlL0ZvbnQKL0VuY29kaW5nL1dpbkFuc2lFbmNvZGluZwovU3VidHlwZS9UeXBlMT4+CmVuZG9iagoxNCAwIG9iago8PC9CYXNlRm9udC9UaW1lcy1Cb2xkL1R5cGUvRm9udAovRW5jb2RpbmcvV2luQW5zaUVuY29kaW5nCi9TdWJ0eXBlL1R5cGUxPj4KZW5kb2JqCjE1IDAgb2JqCjw8L0Jhc2VGb250L1RpbWVzLUl0YWxpYy9UeXBlL0ZvbnQKL0VuY29kaW5nL1dpbkFuc2lFbmNvZGluZwovU3VidHlwZS9UeXBlMT4+CmVuZG9iagoxNiAwIG9iago8PC9CYXNlRm9udC9UaW1lcy1Cb2xkSXRhbGljL1R5cGUvRm9udAovRW5jb2RpbmcvV2luQW5zaUVuY29kaW5nCi9TdWJ0eXBlL1R5cGUxPj4KZW5kb2JqCjE3IDAgb2JqCjw8L0Jhc2VGb250L1phcGZEaW5nYmF0cy9UeXBlL0ZvbnQKL0VuY29kaW5nL1N0YW5kYXJkRW5jb2RpbmcKL1N1YnR5cGUvVHlwZTE+PgplbmRvYmoKMiAwIG9iago8PAovUHJvY1NldCBbL1BERiAvVGV4dCAvSW1hZ2VCIC9JbWFnZUMgL0ltYWdlSV0KL0ZvbnQgPDwKL0YxIDUgMCBSCi9GMiA2IDAgUgovRjMgNyAwIFIKL0Y0IDggMCBSCi9GNSA5IDAgUgovRjYgMTAgMCBSCi9GNyAxMSAwIFIKL0Y4IDEyIDAgUgovRjkgMTMgMCBSCi9GMTAgMTQgMCBSCi9GMTEgMTUgMCBSCi9GMTIgMTYgMCBSCi9GMTMgMTcgMCBSCj4+Ci9YT2JqZWN0IDw8Cj4+Cj4+CmVuZG9iagoxOCAwIG9iago8PAovUHJvZHVjZXIgKGpzUERGIDEuMi42MSAyMDE2LTAzLTMxVDIwOjQxOjU1LjA2Mlo6c2ltb25iZW5ndHNzb24pCi9DcmVhdGlvbkRhdGUgKEQ6MjAyMjA4MTYxNjEyMTQrMDUnMzAnKQo+PgplbmRvYmoKMTkgMCBvYmoKPDwKL1R5cGUgL0NhdGFsb2cKL1BhZ2VzIDEgMCBSCi9PcGVuQWN0aW9uIFszIDAgUiAvRml0SCBudWxsXQovUGFnZUxheW91dCAvT25lQ29sdW1uCj4+CmVuZG9iagp4cmVmCjAgMjAKMDAwMDAwMDAwMCA2NTUzNSBmIAowMDAwMDAwTmFOIDAwMDAwIG4gCjAwMDAwMDBOYU4gMDAwMDAgbiAKMDAwMDAwME5hTiAwMDAwMCBuIAowMDAwMDAwTmFOIDAwMDAwIG4gCjAwMDAwMDBOYU4gMDAwMDAgbiAKMDAwMDAwME5hTiAwMDAwMCBuIAowMDAwMDAwTmFOIDAwMDAwIG4gCjAwMDAwMDBOYU4gMDAwMDAgbiAKMDAwMDAwME5hTiAwMDAwMCBuIAowMDAwMDAwTmFOIDAwMDAwIG4gCjAwMDAwMDBOYU4gMDAwMDAgbiAKMDAwMDAwME5hTiAwMDAwMCBuIAowMDAwMDAwTmFOIDAwMDAwIG4gCjAwMDAwMDBOYU4gMDAwMDAgbiAKMDAwMDAwME5hTiAwMDAwMCBuIAowMDAwMDAwTmFOIDAwMDAwIG4gCjAwMDAwMDBOYU4gMDAwMDAgbiAKMDAwMDAwME5hTiAwMDAwMCBuIAowMDAwMDAwTmFOIDAwMDAwIG4gCnRyYWlsZXIKPDwKL1NpemUgMjAKL1Jvb3QgMTkgMCBSCi9JbmZvIDE4IDAgUgo+PgpzdGFydHhyZWYKTmFOCiUlRU9G"
                JavaScriptInterface(this,this).convertBase64StringToPdfAndStoreIt(base64Str)
//                val intent = Intent(this, WebViewActivity::class.java).putExtra("KEY_URL", url)
//                startActivity(intent)
            }
        }
    }

    private fun validateUrl(url: String): Boolean {
        val validationResult = !url.isEmpty() && url.isValidUrl()
        if (!validationResult)
            Toast.makeText(baseContext, "Please prove a valid URL", Toast.LENGTH_SHORT).show()
        return validationResult
    }

    private fun String.isValidUrl(): Boolean = Patterns.WEB_URL.matcher(this).matches()
}