import { useState } from 'react';

function User({ user }) {
  const { id, nickname, email, type } = user;

  return (
    <tr key={id} className="border-b border-gray-200">
      <td className="py-4 px-6">{id}</td>
      <td className="py-4 px-6">{nickname}</td>
      <td className="py-4 px-6">{email}</td>
      <td className="py-4 px-6">
        <span className={` px-2 py-1 rounded-md ${type === 'ADMIN' ? 'bg-red-300' : 'bg-blue-300'}`}>{type}</span>
      </td>
      <td className="py-4 px-6">
        <button className="btn bg-orange-400 text-white mr-2">Edit</button>
        <button className="btn bg-pink-500 text-white">Delete</button>
      </td>
    </tr>
  );
}

function UserList() {
  const [users, setUsers] = useState([
    {
      id: 1,
      nickname: 'admin',
      email: 'admin@web.tw',
      type: 'ADMIN',
    },
    {
      id: 2,
      nickname: 'user1',
      email: 'user1@web.tw',
      type: 'USER',
    },
    {
      id: 3,
      nickname: 'user2',
      email: 'user2@web.tw',
      type: 'USER',
    },
  ]);
  return (
    <>
      <h2 className="text-center h2">User List</h2>
      <table className="table-auto w-[800px] mx-auto border">
        <thead>
          <tr className="bg-gray-100">
            <th>ID</th>
            <th>Nickname</th>
            <th>Email</th>
            <th>Type</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <User key={user.id} user={user} />
          ))}
        </tbody>
      </table>
    </>
  );
}
export default UserList;
