import {act, fireEvent, render, screen} from "@testing-library/react";
import {BrowserRouter} from "react-router-dom";
import * as React from "react";
import MonPage from "./MonPage";
describe('MonPageTest', () => {
    beforeEach(async () => {

        await act(async () => {
            await render(<MonPage />, {wrapper: BrowserRouter});
        });

    });
    it('h1IsPresentTest', async  () => {
        expect(await screen.findByText("Examen Intra")).toBeInTheDocument()
    });

    it('h3tIsPresentTest', async () => {
        expect(await screen.findByText("Calculatrice web")).toBeInTheDocument()
    });

    it('labelIsPresentTest', async () => {
        const labels = await screen.findAllByText(/One/i);
        const labeltwo = await screen.findAllByText(/Two/i);
        expect(labels.length).toBe(2)
        expect(labeltwo.length).toBe(2)
    });
    it('inputIsPresentTest', async () => {
        const input1 = await screen.findByTestId("addNb1");
        const input2 = await screen.findByTestId("addNb1");
        fireEvent.change(input1, {target: {value:1}})
        expect(input1.value).toBe("1")
        fireEvent.change(input2, {target: {value:4}})
        expect(input2.value).toBe("4")
    });
});