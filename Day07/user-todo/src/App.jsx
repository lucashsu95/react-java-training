import { useState } from 'react';
import Login from './views/Login';
import Signup from './views/Signup';
import TodoList from './views/TodoList';
import UserList from './views/UserList';
import { useEffect } from 'react';
import Nav from './components/Nav';

function App() {
  const hasPage = localStorage.getItem('page') || 'login';
  const hasUser = localStorage.getItem('user');
  const [page, setPage] = useState(hasPage || 'login');
  const [currentUser, setCurrentUser] = useState(hasUser ? JSON.parse(hasUser) : {});

  useEffect(() => {
    localStorage.setItem('page', page);
  }, [page]);

  useEffect(() => {
    if (currentUser) {
      localStorage.setItem('user', JSON.stringify(currentUser));
    }
  }, [currentUser]);

  return (
    <div className="App">
      <Nav setPage={setPage} currentUser={currentUser} setCurrentUser={setCurrentUser} />
      <main className="wraps">
        {page === 'login' && <Login setPage={setPage} setCurrentUser={setCurrentUser} />}
        {page === 'signup' && <Signup setPage={setPage} />}
        {page === 'todos' && <TodoList currentUser={currentUser} />}
        {page === 'users' && <UserList currentUser={currentUser} />}
      </main>
    </div>
  );
}

export default App;
