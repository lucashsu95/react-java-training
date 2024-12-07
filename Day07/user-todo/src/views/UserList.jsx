import { useState } from 'react';
import api from '../api/api';
import AlertDialog from '../api/ApiResponse';
import { useEffect } from 'react';
import DelBtn from '../components/DeleteButton';
import { useRef } from 'react';

function User({ user, setUsers }) {
  const { id, nickname, email, type } = user;
  const [isEdit, setIsEdit] = useState(false);
  const nicknameRef = useRef();
  const emailRef = useRef();

  const saveUser = () => {
    api
      .putUsers({ routeParams: { id }, data: { nickname: nicknameRef.current.value, email: emailRef.current.value } })
      .then((res) => {
        const data = res.data;
        setIsEdit(false);
        setUsers((prevUsers) => prevUsers.map((user) => (user.id === id ? data.data : user)));
        AlertDialog('success', '修改成功');
      })
      .catch((err) => AlertDialog('error', err));
  };

  return (
    <tr key={id} className="border-b border-gray-200 odd:bg-gray-200 hover:bg-gray-300 text-center">
      <td className="py-4 px-6">
        {isEdit ? (
          <input type="text" className="px-2 py-1 rounded-md shadow w-full" defaultValue={nickname} ref={nicknameRef} />
        ) : (
          nickname
        )}
      </td>
      <td className="py-4 px-6 min-w-[200px]">
        {isEdit ? (
          <input type="text" className="px-2 py-1 rounded-md shadow w-full" defaultValue={email} ref={emailRef} />
        ) : (
          email
        )}
      </td>
      <td className="py-4 px-6">
        <span className={` px-2 py-1 rounded-md ${type === 'ADMIN' ? 'bg-red-200' : 'bg-blue-200'}`}>{type}</span>
      </td>
      <td className="py-4 px-6">
        {isEdit ? (
          <button className="btn btn-warning mr-2" onClick={saveUser}>
            儲存
          </button>
        ) : (
          <button className="btn btn-warning mr-2" onClick={() => setIsEdit(true)}>
            編輯
          </button>
        )}
        <DelBtn id={id} deleteFun={api.deleteUsers} setData={setUsers}>
          Del
        </DelBtn>
      </td>
    </tr>
  );
}

export default function UserList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    api
      .getUsers()
      .then((res) => {
        const data = res.data;
        setUsers(data.data);
      })
      .catch((err) => AlertDialog('error', err));
  }, []);

  return (
    <div className="wrap mt-32">
      <h2 className="text-center h2">User List</h2>
      <table className="w-[800px] mx-auto border">
        <thead>
          <tr className="bg-gray-300">
            <th className="w-3/12">暱稱</th>
            <th className="w-5/12">電子郵件</th>
            <th className="w-1/12">角色</th>
            <th className="w-3/12">操作</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <User key={user.id} user={user} setUsers={setUsers} />
          ))}
        </tbody>
      </table>
    </div>
  );
}
