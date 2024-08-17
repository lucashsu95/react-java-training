import { useEffect } from 'react';
import { useApi } from '../hooks/useApi';

export default function Nav({ setPage, currentUser, setCurrentUser }) {
  const { data, error, postData } = useApi();
  const logout = () => {
    postData('http://localhost:8000/api/users/logout');
  };

  useEffect(() => {
    if (data) {
      if (data.success) {
        setCurrentUser({});
        alert('登出成功');
        setPage('login');
      } else {
        alert('登出失敗', data.message);
      }
    }
  }, [data]);

  useEffect(() => {
    if (error) {
      alert(error);
    }
  }, [error]);

  return (
    <nav className="flex justify-between px-10 py-4 bg-slate-600 text-white shadow-[2px_0_15px] shadow-indigo-300 items-center fixed w-full top-0">
      <h1 className="h1 cursor-pointer" onClick={() => setPage('login')}>
        待辦事項管理系統
      </h1>
      {currentUser?.nickname && (
        <>
          <ul className="flex items-center gap-5">
            <li>
              <a onClick={logout}>登出</a>
            </li>
            <li>
              <a>{currentUser?.nickname}</a>
            </li>
          </ul>
        </>
      )}
    </nav>
  );
}
