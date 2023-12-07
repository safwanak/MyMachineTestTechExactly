package com.user.nestmarket.utils.helper.sidemenu

object SideMenuHelper {

    /*fun attachCopyRightView(copyRightView: TextView, activity: Activity) {
        val copyRight =
            "Copyright © ${DateHelper.getCurrentYear()} by Inmate Inbox. All Rights Reserved. Read Terms and service & Privacy Policy"

        val span1: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                val i = Intent(activity, TermsActivity::class.java)
                i.putExtra("toScreen", "terms")
                activity.startActivity(i)
            }
        }

        val span2: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                val i = Intent(activity, TermsActivity::class.java)
                i.putExtra("toScreen", "privacy")
                activity.startActivity(i)
            }
        }

        val ss = SpannableString(copyRight)
        ss.setSpan(span1, 60, 77, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(span2, 80, 94, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        copyRightView.text = ss
        copyRightView.setTextColor(activity.resources.getColor(R.color.fullWhite, null))
        copyRightView.movementMethod = LinkMovementMethod.getInstance()
    }*/
}