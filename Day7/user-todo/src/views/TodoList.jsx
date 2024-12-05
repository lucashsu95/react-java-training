import { useState, useEffect } from 'react';
import { useRef } from 'react';
import DelBtn from '../components/DeleteButton';
import api from '../api/api';
import AlertDialog from '../api/ApiResponse';

const Todo = ({ todo, setTodos, setIsEdit, titleRef, contentRef, setEditId, resetForm, isEdit }) => {
  const { id, title, content, completed } = todo;

  const updateTodoComputed = () => {
    api
      .putTodo({ data: { completed: !completed }, routeParams: { id } })
      .then((res) => {
        const data = res.data;
        setTodos((prev) => prev.map((todo) => (todo.id === id ? data.data : todo)));
      })
      .catch((err) => {
        AlertDialog('error', err);
      });
  };

  return (
    <li className="bg-white p-3 rounded shadow flex items-center w-full max-w-[400px] mx-auto hover:bg-gray-100">
      <div className="flex-grow">
        <div className="flex items-center">
          <input
            type="checkbox"
            id={todo.id}
            className="mr-4 w-4 h-4 peer accent-pink-500"
            onChange={updateTodoComputed}
            checked={completed || false}
          />
          <label htmlFor={todo.id} className="peer-checked:line-through">
            <h3 className="h3">{title}</h3>
          </label>
        </div>
        <p className="text-gray-500 ml-8">{content}</p>
      </div>
      {isEdit ? (
        <button className="btn btn-secondary mr-2" onClick={resetForm}>
          取消
        </button>
      ) : (
        <button
          className="btn btn-warning mr-2"
          onClick={() => {
            titleRef.current.value = title;
            contentRef.current.value = content;
            setIsEdit(true);
            setEditId(id);
          }}
        >
          修改
        </button>
      )}
      <DelBtn id={todo.id} deleteFun={api.deleteTodo} setData={setTodos} />
    </li>
  );
};

export default () => {
  const [todos, setTodos] = useState([]);
  const [editId, setEditId] = useState(null);
  const title = useRef();
  const content = useRef();

  const [isEdit, setIsEdit] = useState(false);

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

    const payload = { title: title.current.value, content: content.current.value };
    api
      .postTodo({ data: payload })
      .then((res) => {
        const data = res.data;
        setTodos((prev) => [...prev, data.data]);
        title.current.value = '';
        content.current.value = '';
        AlertDialog('success', '新增成功');
      })
      .catch((err) => {
        AlertDialog('error', err);
      });
  };

  const updateTodo = (e) => {
    e.preventDefault();
    const payload = { title: title.current.value, content: content.current.value };
    api
      .putTodo({ data: payload, routeParams: { id: editId } })
      .then(({ data }) => {
        setTodos((prev) => prev.map((todo) => (todo.id === editId ? data.data : todo)));
        AlertDialog('success', '修改成功');
      })
      .catch((err) => AlertDialog('error', err));
  };

  const resetForm = () => {
    setIsEdit(false);
    setEditId(null);
    title.current.value = '';
    content.current.value = '';
  };

  return (
    <div className="wraps">
      <section className="w-5/6 grid grid-cols-2 [&>*]:px-4">
        <form className="flex flex-col border-r border-gray-500" onSubmit={isEdit ? updateTodo : handleSubmit}>
          <h2 className="h2 text-center">{isEdit ? '修改' : '新增'}待辦</h2>
          <div className="flex flex-col mx-auto">
            <div className="flex flex-col">
              標題：
              <input type="text" className="input mb-1" placeholder="待辦事項標題" ref={title} />
              內容：
              <textarea rows="3" className="input" placeholder="待辦事項內容" ref={content}></textarea>
            </div>
            <div>
              <button type="submit" className="btn btn-primary mr-2">
                {isEdit ? '修改' : '新增'}
              </button>
              <button type="reset" className="btn btn-secondary">
                重設
              </button>
            </div>
          </div>
        </form>

        <div className="flex flex-col">
          <h2 className="h2 text-center">待辦事項列表</h2>
          {todos && todos.length > 0 ? (
            <ul className="mt-4 space-y-2">
              {todos.map((todo) => (
                <Todo
                  key={todo.id}
                  todo={todo}
                  setTodos={setTodos}
                  setIsEdit={setIsEdit}
                  titleRef={title}
                  contentRef={content}
                  setEditId={setEditId}
                  resetForm={resetForm}
                  isEdit={isEdit}
                />
              ))}
            </ul>
          ) : (
            <p className="mt-4 text-gray-500">目前沒有待辦事項</p>
          )}
        </div>
      </section>
    </div>
  );
};
