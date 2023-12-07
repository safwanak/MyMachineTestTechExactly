package com.user.nestmarket.utils.network

object ApiEndPoint {

    /*** Login ***/
    const val apiLogin = "nest/login"

    /*** OTP ***/
    const val apiOtp = "nest/loginVerifyCode"

    /*** Registration ***/
    const val apiSignUp = "nest/register"

    /*** Forgot Password ***/
    const val apiForgotPassword = "nest/forgetPassword"
    const val apiVerifyCode = "nest/verifyPassword"
    const val apiChangePassword = "nest/newPassword"

    /*** DashBoard List APIs ***/
    const val apiListCategory = "nest/listCategory"
    const val apiListFilters = "nest/filterby"
    const val apiListItems = "nest/categoryWiseList"
    const val apiUpdateFavourites = "nest/favourites"
    const val apiWalletAmount = "nest/userWalletAmount"
    const val apiWalletTransaction = "nest/getUserWalletTransaction"
    const val apiSearchItems = "nest/searchItems"

    /*** Settings APIs ***/
    const val apiUserProfile = "nest/userProfile"
    const val apiUserUpdateProfile = "nest/updateProfile"
    const val apiUserChangePassword = "nest/changePassword"
    const val apiVerifyBeforeDelete = "nest/verifyUserData"
    const val apiDeleteProfile = "nest/deleteUser"
    const val apiInviteFriend = "nest/invite"

    /*** MarketPlace APIs ***/
    const val apiIndividualItems = "nest/individualItems"

    /*** Credit APIs ***/
    const val apiRedeemWallet = "nest/walletTransaction"

    /*** Card APIs ***/
    const val apiGetCards = "nest/listuserCards"
    const val apiInsertCards = "nest/createuserCards"
    const val apiDeleteCards = "nest/deleteuserCards"

    const val apiAddItem = "nest/addItems"
    const val apiSaleItems = "nest/approvedItems"
    const val apiPurchaseItems = "nest/purchasedItems"
    const val apiItemRenewal = "nest/itemRenewal"

    const val apiReportAbuse = "nest/reportAbuse"
    const val apiGetCommission = "nest/getCommission"
    const val apiValidateCoupon = "nest/validateCoupon"
    const val apiAddGrid = "nest/addGrid"
    const val apiPaymentIntent = "nest/paymentIntent"
    const val apiUpdatePayment = "nest/updatePayment"
    const val apiImageAppend = "nest/imageAppend"
    const val apiItemResell = "nest/itemResell"

    /*** EditImage APIs ***/
    const val apiGetEditImage = "nest/getEditImageUnitDetail"

}