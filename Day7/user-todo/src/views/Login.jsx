import { useRef } from 'react';
import api from '../api/api';
import AlertDialog from '../api/ApiResponse';

function Login({ setPage, setCurrentUser }) {
  const email = useRef();
  const password = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();

    api
      .postLogin({
        data: {
          email: email.current.value,
          password: password.current.value,
        },
      })
      .then((res) => {
        const data = res.data;
        AlertDialog('success', '登入成功');
        setCurrentUser({
          nickname: data.data.nickname,
          email: data.data.email,
          type: data.data.type,
          accessToken: data.data.access_token,
        });
        setPage('todo');
      })
      .catch((err) => AlertDialog('error', err));
  };

  return (
    <div className="wrap">
      <h2 className="h2">登入</h2>
      <form onSubmit={handleSubmit}>
        <p>
          <input type="text" placeholder="Email" className="input" ref={email} />
        </p>
        <p>
          <input type="password" placeholder="Password" className="input" ref={password} />
        </p>
        <button type="submit" className="btn btn-primary mr-3">
          送出
        </button>
        <button className="btn btn-secondary">重設</button>
        <p className="mt-3">
          <span className="text-gray-400">沒有帳號嗎？</span>
          <a onClick={() => setPage('signup')} className="text-sky-400 cursor-pointer">
            註冊
          </a>
        </p>
      </form>
    </div>
  );
}
export default Login;
