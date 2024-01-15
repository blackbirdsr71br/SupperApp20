package com.alex.dashboarddemo.presentation.dashboard.gsvcCouponCardimport java.text.ParseExceptionimport java.text.SimpleDateFormatimport java.util.*import java.util.regex.Matcherimport java.util.regex.Patternval localeEs419 = Locale("es", "419")const val shortDateFormatPattern = "dd/MM/yyyy hh:mm:ss a"enum class TypeHourFormat {    HH_MM_SS, H_MM}enum class TypeDateFormat {    SHORT, LONG}fun String.ticketDateFormat(typeDateFormat: TypeDateFormat = TypeDateFormat.LONG): String {    val dateStringWordList = this.lowercase().trim().split(" ").toMutableList()    if (dateStringWordList.size == 6) {        dateStringWordList.add(4, "del")        dateStringWordList.add(5, getYear(Date()))    }    if (dateStringWordList.size >= 8) {        val day = dateStringWordList[1]        val month = String.format("%02d", getMonthNumber(dateStringWordList[3]))        val year = dateStringWordList[5]        val hour = dateStringWordList[6] + " " + dateStringWordList[7]        val shortDate = "$day/$month/$year $hour"        val validateDate = validateDate(dateString = shortDate, pattern = shortDateFormatPattern)        if (validateDate) {            if (typeDateFormat == TypeDateFormat.SHORT) return shortDate            return getDateFormat(shortDate)        }    }    if (typeDateFormat == TypeDateFormat.SHORT) {        return timestampToStandardizedDateFormat(            Date().time,            TypeDateFormat.SHORT,        )    }    return timestampToStandardizedDateFormat(Date().time)}fun timestampToStandardizedDateFormat(    dateTimestamp: Long,    typeDateFormat: TypeDateFormat = TypeDateFormat.LONG,    typeHourFormat: TypeHourFormat = TypeHourFormat.HH_MM_SS,): String {    val date = Date(dateTimestamp)    val formatTime = if (typeHourFormat == TypeHourFormat.H_MM) "h:mm" else "hh:mm:ss"    val pattern =        if (typeDateFormat == TypeDateFormat.SHORT) "dd/MM/yyyy $formatTime a" else "EEEE dd 'de' MMMM 'del' yyyy $formatTime a"    val formatter = SimpleDateFormat(pattern, localeEs419)    return formatter.format(date).replace("a.m.", "am").replace("p.m.", "pm")}fun getMonthNumber(monthName: String): Int {    val monthFormat = SimpleDateFormat("MMM", localeEs419)    var calendar: Calendar? = null    return try {        val date = monthFormat.parse(monthName)        calendar = Calendar.getInstance().apply {            if (date != null) {                time = date            }        }        calendar.get(Calendar.MONTH) + 1    } catch (e: ParseException) {        0    } finally {        calendar?.clear()    }}fun validateDate(dateString: String, pattern: String): Boolean {    val dateStrings = dateString.replace("am", "a.m.").replace("pm", "p.m.")    val sdf = SimpleDateFormat(pattern, localeEs419)    sdf.isLenient = false    return try {        sdf.parse(dateStrings)        true    } catch (e: Exception) {        false    }}fun getDateFormat(dateString: String): String {    val dateStrings = dateString.replace("am", "a.m.").replace("pm", "p.m.")    val sdf = SimpleDateFormat(shortDateFormatPattern, localeEs419)    val date = sdf.parse(dateStrings)    return timestampToStandardizedDateFormat(date?.time ?: 0)}fun getYear(date: Date): String {    val calendar = Calendar.getInstance()    calendar.time = date    val year = calendar.get(Calendar.YEAR).toString()    calendar.clear()    return year}fun String.hasRepeatedCharacters(): Boolean {    return groupingBy { it }.eachCount().filter { it.value > 2 }.isNotEmpty()}fun String.hasConsecutiveNumbers(): Boolean {    val claveInt = map { it.code }    var consecutive = 0    for (i in 1 until claveInt.size) {        if (claveInt[i] - claveInt[i - 1] == 1) {            consecutive++        }        if (consecutive >= 2) {            return true        }    }    consecutive = 0    for (i in 1 until claveInt.reversed().size) {        if (claveInt[i] - claveInt[i - 1] == -1) {            consecutive++        }        if (consecutive >= 2) {            return true        }    }    return false}fun String.getInitialLetters(): String {    if (this.isNotBlank()) {        val name: String = this.lowercase().trim()        val removeSpace = "\\s+".toRegex()        val punctuationMarks =            "[.’'\\[\\](){}⟨⟩:,،、‒–—―…!‹›«»‐\\-?‘“”\";/⁄·&*@•‡°¡¿※#№÷×ºª%‰+−=‱¶′″‴§~_|‖¦©℗®℠™¤₳฿₵¢₡₢\$₫₯֏₠€ƒ₣₲₴₭₺₾ℳ₥₦₧₱₰£៛₽₹₨₪৳₸₮₩¥]".toRegex()        val prepositionWords =            "([^\\w]* de los [^\\w]*)|([^\\w]* de las [^\\w]*)|([^\\w]* de la [^\\w]*)|([^\\w]* del [^\\w]*)|([^\\w]* de [^\\w]*)|([^\\w]*di[^\\w]*)|([^\\w]* y [^\\w]*)".toRegex()        val nameRemovePunctuationMarks = name.replace(punctuationMarks, "")        val nameRemovePrepositionsWords = nameRemovePunctuationMarks.replace(prepositionWords, " ")        val nameRemoveSpace = nameRemovePrepositionsWords.replace(removeSpace, " ").trim()        if (nameRemoveSpace.isNotBlank()) {            val wordsArray = nameRemoveSpace.split(" ")            return when (wordsArray.size) {                0 -> {                    ""                }                1 -> {                    wordsArray[0].wordOneEmojiOrInitialsLetter()                }                2 -> {                    wordsArray[0].wordOneEmojiOrInitialsLetter() + wordsArray[1].wordOneEmojiOrInitialsLetter()                }                else -> {                    wordsArray[0].wordOneEmojiOrInitialsLetter() + wordsArray[wordsArray.size - 2].wordOneEmojiOrInitialsLetter()                }            }        } else {            return ""        }    } else {        return ""    }}fun String.wordOneEmojiOrInitialsLetter(): String {    val word = this    val results: MutableList<String> = ArrayList()    val m: Matcher = Pattern.compile("\\P{M}\\p{M}*+").matcher(word)    while (m.find()) {        results.add(m.group())    }    return results[0].uppercase(Locale.getDefault())}fun String.charactersFormat(maxCharacters: Int): String {    return if (this.length <= maxCharacters) {        this    } else {        this.substring(0, maxCharacters - 3) + "..."    }}