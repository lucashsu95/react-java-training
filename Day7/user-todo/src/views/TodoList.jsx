import { useState, useEffect } from 'react';
import { useApi } from '../hooks/useApi';
import { useRef } from 'react';

export default function TodoList() {
  const [todos, setTodos] = useState();
  const title = useRef();
  const content = useRef();

  const { data, error, setError, getData } = useApi();

  useEffect(() => {
    getData('http://localhost:8000/api/todos');
  }, []);

  useEffect(() => {
    if (data) {
      if (data.success) {
        setTodos(data.data);
        console.log(data.data);
      } else {
        alert(data.message);
      }
    }
  }, [data]);

  useEffect(() => {
    if (error) {
      alert(error);
      setError(null);
    }
  }, [error]);

  return (
    <div className="flex flex-col items-center">
      <section className="grid grid-cols-2">
        <form className="flex flex-col">
          <h2 className="h2 text-center">待辦事項列表</h2>
          <div className="flex flex-col">
            <input type="text" className="input mb-1" placeholder="待辦事項標題" ref={title} />
            <textarea name="" id="" rows="3" className="input" placeholder="待辦事項內容" ref={content}></textarea>
          </div>
          <div>
            <button type="submit" className="btn btn-primary mr-2">
              新增
            </button>
            <button type="reset" className="btn btn-secondary">
              重設
            </button>
          </div>
        </form>
        <div className="flex justify-end">
          {todos && todos.length > 0 ? (
            <ul className="mt-4 space-y-2">
              {todos.map((todo) => (
                <li key={todo.id} className="bg-white p-3 rounded shadow">
                  {todo.title}
                </li>
              ))}
            </ul>
          ) : (
            <p className="mt-4 text-gray-500">目前沒有待辦事項</p>
          )}
        </div>
      </section>
    </div>
  );
}
