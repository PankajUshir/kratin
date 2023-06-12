import './Button.css';
function Home() {
    return (
        <>
            <hr />
            <button className="button"><a href="/expenses">Current Month Bill </a></button>
            <hr />
            <button><a href="/checkup">Checkup</a></button>
            <hr/>
        </>
    )
}
export default Home;