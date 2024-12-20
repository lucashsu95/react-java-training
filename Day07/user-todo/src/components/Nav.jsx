import api from '../api/api';
import AlertDialog from '../api/ApiResponse';

export default function Nav({ setPage, currentUser, setCurrentUser }) {
  const logout = () => {
    api
      .postLogout()
      .then(() => {
        setCurrentUser({});
        AlertDialog('success', '登出成功');
        setPage('login');
      })
      .catch((err) => AlertDialog('error', err));
  };

  return (
    <nav className="flex justify-between px-10 py-4 bg-slate-600 text-white shadow-[2px_0_15px] shadow-indigo-300 items-center fixed w-full top-0">
      <h1 className="text-2xl font-bold cursor-pointer" onClick={() => setPage('login')}>
        待辦事項管理系統
      </h1>
      {currentUser?.nickname && (
        <>
          <ul className="flex items-center gap-5">
            {currentUser?.nickname && <li>Hello {currentUser.nickname}!</li>}
            <li>
              <a onClick={() => setPage('todos')}>待辦事項管理</a>
            </li>
            {currentUser?.type === 'ADMIN' && (
              <li>
                <a onClick={() => setPage('users')}>會員管理</a>
              </li>
            )}
            <li>
              <a onClick={logout}>登出</a>
            </li>
          </ul>
        </>
      )}
    </nav>
  );
}
