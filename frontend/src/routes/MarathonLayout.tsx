import { Outlet } from "react-router";


export default function MarathonLayout() {
    return (
        <>
            <div className="flex min-h-dvh">
                <div className="min-w-[200px] bg-[#301050]"></div>
                <div className="flex flex-col w-full">
                    <div className=" bg-[#F2EAFA] min-h-[50px]"></div>
                    <Outlet></Outlet>
                </div>
            </div>
        </>
    )
}