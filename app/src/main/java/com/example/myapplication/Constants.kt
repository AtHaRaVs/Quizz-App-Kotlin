package com.example.myapplication

object Constants {

    const val userName: String = "userName"
    const val totalQuestions: String = "totalQuestions"
    const val correctAnswers: String = "correctAnswers"

    fun getQuestions(): ArrayList<Question>{

        var questionsList = ArrayList<Question>()

        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.germany,
            "Argentina", "Germany",
            "Armenia", "Austria", 2
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.guinea,
            "Guinea", "Austria",
            "Australia", "Armenia", 1
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.georgia,
            "Belarus", "Belize",
            "Brunei", "Georgia", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.france,
            "Bahamas", "France",
            "Barbados", "Belize", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.finland,
            "Gabon", "France",
            "Finland", "Fiji", 3
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.estonia,
            "Estonia", "Georgia",
            "Greece", "none of these", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.egypt,
            "Dominica", "Denmark",
            "Egypt", "Ethiopia", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.djibouti,
            "Ireland", "Iran",
            "Hungary", "Djibouti", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.easttimor,
            "Australia", "EastTimor",
            "Tuvalu", "United States of America", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.grenada,
            "Grenada", "Jordan",
            "Sudan", "Palestine", 1
        )

        questionsList.add(que10)

        return questionsList
    }
}