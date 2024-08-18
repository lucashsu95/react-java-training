import AlertDialog from '../api/ApiResponse';

const DeleteButton = ({ id, deleteFun, setData }) => {
    
  const handleDelete = () => {
    if (confirm('確定要刪除嗎？')) {
      deleteFun({ routeParams: { id } })
        .then((res) => {
          console.log(res);
          setData((prevData) => prevData.filter((item) => item.id !== id));
          AlertDialog('success', '刪除成功');
        })
        .catch((err) => AlertDialog('error', err));
    }
  };

  return (
    <button onClick={handleDelete} className="btn btn-danger">
      刪除
    </button>
  );
};

export default DeleteButton;
