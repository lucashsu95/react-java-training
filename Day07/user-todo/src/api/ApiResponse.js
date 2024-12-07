import Swal from "sweetalert2";

const ALERT_DIALOG_TYPE = {
    'MSG_INVALID_LOGIN': '帳密有誤',
    'MSG_USER_EXISTS': '使用者已存在',
    'MSG_INVALID_ACCESS_TOKEN': '無效的 Access token 請重新登入',
    'MSG_PERMISSION_DENY': '權限不足',
    'MSG_MISSING_FIELD': '缺少必要欄位',
    'MSG_WRONG_DATA_TYPE': '資料格式/型態錯誤',
    'MSG_USER_NOT_EXISTS': '不存在的使用者',

    'success': '成功',
    'error': '錯誤',
}

export default function AlertDialog(type, msg, textType = 'text') {
    msg = msg?.response?.data?.message ?? msg
    const message = msg in ALERT_DIALOG_TYPE ? ALERT_DIALOG_TYPE[msg] : msg

    let text;
    if (textType === 'html') text = { html: message }
    else text = { text: message }

    Swal.fire({
        icon: type,
        title: ALERT_DIALOG_TYPE[type],
        confirmButtonText: 'OK',
        ...text,
    })
}