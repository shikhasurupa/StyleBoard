import logo from './logo.svg';
import './App.css';
import LoginRegister from './Component/LoginRegister/LoginRegister';
import Feed from './Component/Feed/FeedScreen';
import { Routes, Route} from 'react-router-dom'

function App() {
  return (
    <div>
      <Routes>
        <Route path='/' element={<LoginRegister />} />
        <Route path='/feed' element={<Feed />} />
      </Routes>
    </div>
  );
}

export default App;
