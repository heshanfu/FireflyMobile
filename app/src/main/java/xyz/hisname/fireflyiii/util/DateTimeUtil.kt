package xyz.hisname.fireflyiii.util

import org.threeten.bp.*
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.TextStyle
import org.threeten.bp.temporal.TemporalAdjusters
import org.threeten.bp.temporal.TemporalAdjusters.*
import org.threeten.bp.temporal.WeekFields
import java.lang.Long.parseLong
import java.util.*


object DateTimeUtil {

    fun getCalToString(date: String): String{
        return Instant.ofEpochMilli(parseLong(date))
                .atOffset(OffsetDateTime.now().offset)
                .toLocalDate()
                .toString()
    }

    /*
    Takes in end date in yyyy-MM-dd format
    Output difference in *DAYS*
     */
    fun getDaysDifference(date: String?): String {
        val todayDate = LocalDateTime.now().toLocalDate()
        val localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        return Duration.between(todayDate.atStartOfDay(), localDate.atStartOfDay()).toDays().toString()
    }

    /*
    Accepts only yyyy-MM-dd parameter.
    Output day in short form
     */
    fun getDayOfWeek(date: String): String{
        val localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        return localDate.dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    }

    // Returns end of month date in yyyy-MM-dd (2018-01-04)
    fun getEndOfMonth(): String{
        val localDateTime = LocalDate.now()
        val localDate = LocalDate.of(localDateTime.year, localDateTime.monthValue, localDateTime.dayOfMonth)
        return localDate.withDayOfMonth(localDate.lengthOfMonth()).toString()
    }

    fun getEndOfMonth(duration: Long): String{
        val localDateTime = LocalDate.now()
        val previousMonth = localDateTime.minusMonths(duration)
        val previousLocalDate =
                LocalDate.of(previousMonth.year, previousMonth.monthValue, previousMonth.dayOfMonth)
        return previousLocalDate.withDayOfMonth(previousMonth.lengthOfMonth()).toString()
    }

    fun getStartOfMonth(duration: Long): String {
        val localDateTime = LocalDate.now()
        return localDateTime.minusMonths(duration).toString()
    }

    fun getStartOfMonth(): String{
        val localDateTime = LocalDate.now()
        val localDate = LocalDate.of(localDateTime.year, localDateTime.monthValue, localDateTime.dayOfMonth)
        return localDate.with(firstDayOfMonth()).toString()
    }

    fun getStartOfYear(): String {
        val localDateTime = LocalDate.now()
        val localDate = LocalDate.of(localDateTime.year, localDateTime.monthValue, localDateTime.dayOfMonth)
        return localDate.with(firstDayOfYear()).toString()
    }

    fun getEndOfYear(): String {
        val localDateTime = LocalDate.now()
        val localDate = LocalDate.of(localDateTime.year, localDateTime.monthValue, localDateTime.dayOfMonth)
        return localDate.with(lastDayOfYear()).toString()
    }

    fun getStartOfWeek(): String {
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
        return LocalDate.now().with(TemporalAdjusters.previousOrSame(firstDayOfWeek)).toString()
    }

    fun getEndOfWeek(): String {
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
        val lastDayOfWeek = DayOfWeek.of(((firstDayOfWeek.value + 5) %
                DayOfWeek.values().size) + 1)
        return LocalDate.now().with(TemporalAdjusters.nextOrSame(lastDayOfWeek)).toString()
    }

    fun getCurrentMonth(): String {
        val localDateTime = LocalDate.now()
        val localDate = LocalDate.of(localDateTime.year, localDateTime.monthValue, localDateTime.dayOfMonth)
        return localDate.month.getDisplayName(TextStyle.FULL, Locale.getDefault())
    }

    fun getCurrentMonthShortName(): String{
        val localDateTime = LocalDate.now()
        val localDate = LocalDate.of(localDateTime.year, localDateTime.monthValue, localDateTime.dayOfMonth)
        return localDate.month.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    }

    fun getPreviousMonth(duration: Long): String{
        val localDateTime = LocalDate.now()
        return localDateTime.minusMonths(duration).month.getDisplayName(TextStyle.FULL, Locale.getDefault())
    }

    fun getPreviousMonthShortName(duration: Long): String{
        val localDateTime = LocalDate.now()
        return localDateTime.minusMonths(duration).month.getDisplayName(TextStyle.SHORT, Locale.getDefault())
    }

    fun getTodayDate(): String{
        return LocalDate.now().toString()
    }
}