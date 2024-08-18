import { useState, useEffect } from 'react';
import { useRef } from 'react';
import api from '../api/api';
import AlertDialog from '../api/ApiResponse';

export default function TodoList() {
  const [todos, setTodos] = useState([]);
  const title = useRef();
  const content = useRef();

  useEffect(() => {
    api
      .getTodos()
      .then((res) => {
        const data = res.data;
        setTodos(data.data);
      })
      .catch((error) => alert(error));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('submit');

    const payload = { title: title.current.value, content: content.current.value };
    api
      .postTodo({ data: payload })
      .then((res) => {
        const data = res.data;
        AlertDialog('success', '新增成功');
        setTodos((prev) => [...prev, data.data]);
        title.current.value = '';
        content.current.value = '';
      })
      .catch((err) => {
        console.log(err);
        AlertDialog('error', err);
      });
  };

  const updateTodo = (e) => {
    console.log(e.target.checked);
  };

  return (
    <div className="flex flex-col items-center">
      <section className="grid grid-cols-2 [&>*]:px-4">
        <form className="flex flex-col border-r border-gray-500" onSubmit={handleSubmit}>
          <h2 className="h2 text-center">新增待辦</h2>
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
        <div className="flex items-center flex-col">
          <h2 className="h2">待辦事項列表</h2>
          {todos && todos.length > 0 ? (
            <ul className="mt-4 space-y-2">
              {todos.map((todo) => (
                <li key={todo.id} className="bg-white p-3 rounded shadow flex items-center w-72 hover:bg-gray-100">
                  <div className="flex-grow">
                    <div className="flex items-center">
                      <input
                        type="checkbox"
                        id={todo.id}
                        className="mr-4 w-4 h-4 peer accent-pink-500"
                        onChange={updateTodo}
                        checked={todo.isCompleted}
                      />
                      <label htmlFor={todo.id} className="peer-checked:line-through">
                        <h3 className="h3">{todo.title}</h3>
                      </label>
                    </div>
                    <p className="text-gray-500 ml-8">{todo.content}</p>
                  </div>
                  <button className="btn btn-danger flex-grow-0">刪除</button>
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
