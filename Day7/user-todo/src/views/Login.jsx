import { useRef } from 'react';
import { useApi } from '../hooks/useApi';
import { useEffect } from 'react';

function Login({ setPage, setCurrentUser }) {
  const email = useRef();
  const password = useRef();
  const { data, error, postData } = useApi();

  const handleSubmit = (e) => {
    e.preventDefault();
    const payload = {
      email: email.current.value,
      password: password.current.value,
    };
    postData('http://localhost:8000/api/users/login', payload);
  };

  useEffect(() => {
    if (data) {
      console.log('資料:', data);
      if (data.success) {
        alert('登入成功');
        const user = {
          nickname: data.data.nickname,
          email: data.data.email,
          type: data.data.type,
          accessToken: data.data.access_token,
        };
        console.log('user:', user);
        setCurrentUser(user);
        setPage('todo');
      } else {
        alert('登入失敗: ' + data.message);
      }
    }
  }, [data, setPage]);

  useEffect(() => {
    if (error) {
      alert(error);
    }
  }, [error]);

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
