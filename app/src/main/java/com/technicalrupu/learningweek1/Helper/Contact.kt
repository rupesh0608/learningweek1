package com.technicalrupu.learningweek1.Helper

import android.app.Activity
import android.database.Cursor
import android.provider.ContactsContract
import com.technicalrupu.learningweek1.ContactActivity.ContactDetails

class Contact(val ref: Activity) {

    fun getContactList(): ArrayList<ContactDetails> {

        val contactList = ArrayList<ContactDetails>()

        val cr = ref.contentResolver
        val cur: Cursor? = cr.query(
            ContactsContract.Contacts.CONTENT_URI,
            null, null, null, null
        )
        if ((if (cur != null) cur.getCount() else 0) > 0) {
            while (cur != null && cur.moveToNext()) {
                val id: String = cur.getString(
                    cur.getColumnIndex(ContactsContract.Contacts._ID)
                )
                val name: String = cur.getString(
                    cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME
                    )
                )
                if (cur.getInt(
                        cur.getColumnIndex(
                            ContactsContract.Contacts.HAS_PHONE_NUMBER
                        )
                    ) > 0
                ) {
                    val pCur: Cursor? = cr.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        arrayOf(id),
                        null
                    )
                    if (pCur != null) {
                        while (pCur.moveToNext()) {
                            val phoneNo: String = pCur.getString(
                                pCur.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER
                                )
                            )
                            contactList.add(ContactDetails(id.toInt(), name, phoneNo))
                        }
                    }
                    pCur?.close()
                }
            }
        }
        cur?.close()
        return contactList
    }
}