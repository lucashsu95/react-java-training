import { useRef } from 'react';
import api from '../api/api';
import AlertDialog from '../api/ApiResponse';

function Signup({ setPage }) {
  const email = useRef();
  const password = useRef();
  const nickname = useRef();
  const type = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();

    const payload = {
      email: email.current.value,
      password: password.current.value,
      nickname: nickname.current.value,
      type: type.current.value,
    };
    api
      .postUsers({ data: { payload } })
      .then(() => {
        AlertDialog('success', '註冊成功');
        setPage('login');
        email.current.value = '';
        password.current.value = '';
        nickname.current.value = '';
      })
      .catch((err) => AlertDialog('error', err));
  };

  return (
    <div className="wrap">
      <h2 className="h2">註冊</h2>
      <form onSubmit={handleSubmit}>
        <p>
          <input type="text" placeholder="Email" className="input" ref={email} />
        </p>
        <p>
          <input type="text" placeholder="Password" className="input" ref={password} />
        </p>
        <p>
          <input type="text" placeholder="Nickname" className="input" ref={nickname} />
        </p>
        <p>
          <select className="input" ref={type}>
            <option value="USER">使用者</option>
            <option value="ADMIN">管理員</option>
          </select>
        </p>
        <button type="submit" className="btn btn-primary mr-3">
          送出
        </button>
        <button className="btn btn-secondary">重設</button>
        <p className="mt-3">
          <span className="text-gray-400">已經有帳號嗎？</span>
          <button onClick={() => setPage('login')} className="text-sky-400 cursor-pointer">
            登入
          </button>
        </p>
      </form>
    </div>
  );
}

export default Signup;
