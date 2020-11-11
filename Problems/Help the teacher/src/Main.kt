// The previous code that forms the report

val regex = Regex(". wrong answers?")
if (report.matches(regex)) print(true)
else print(false)